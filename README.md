# RobustDialogFragment: DialogFragment can be robust

<br>`DialogFragment` works great with `Dialog` and `Fragment`. 
<br>But `DialogFragment` is not always working stable.
Scenes like: 
* Try to show `DialogFragment` when `Activity` or `Fragment` has been destroyed or state-saved, which will throws `IllegalStateException`, like
    * **_Can not perform this action after onSaveInstanceState_**.
    * **_fragment {xxx} not associated with a fragment manager_**.
* `DialogFragment` can't work well with in-layout Fragments, which cause `IllegalArgumentException`, like
    * **_Binary XML file line #30: Duplicate id 0x7f080047_**.
* Sometimes `DialogFragment` cause memory leaks.

<br> For how official DialogFragment leaks memory, As we know, 
<br>official `DialogFragment` works with `Activity`/`Fragment` through `FragmentManager`.
<br>There is `mDialog` in `DialogFragment` which implements `DialogInterface.OnDismissListener` and `mDialog.setOnDismissListener(this)` where `this` is `current DialogFragment`.
<br>In `Dialog#setOnDismissListener(listener)`, `Dialog#mDismissMessage = mListenersHandler.obtainMessage(DISMISS, listener)`, so `Dialog#mDismissMessage#obj` is `listener`, namely `current DialogFragment`.
<br>So, a `Message` referred `DialogFragment`, which referred `Activity/Fragment` through `FragmentManager`.
<br>Meantime, in `Looper#loop()`, there is `Message msg = queue.next()`, which will block current Thread when no messages in `MessageQueue`.
<br>When `MessageQueue` has no messages, `queue.next()` block current Thread while local variable `msg` has been allocated.
<br>DialogFragment instance referred by msg won't be gc, and therefore Activity/Fragment won't be gc.
<br>So Memory leaks happen.

So, my solution is: When `Dialog#setOnDismissListener(listener)`, the `listener` holds `DialogFragment` **instance** by `WeakReference`. So, when `MessageQueue` blocks, local variable `msg` won't hold `DialogFragment` instance.
Memory won't leak by MessageQueue#next()#msg or Activity/Fragment.

## Stargazers over time

[![Stargazers over time](https://starchart.cc/bytebeats/RobustDialogFragment.svg)](https://starchart.cc/bytebeats/RobustDialogFragment)

## MIT License

    Copyright (c) 2021 Chen Pan

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.

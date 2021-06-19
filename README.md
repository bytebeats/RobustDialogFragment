# RobustDialogFragment: DialogFragment can be robust

<br>`DialogFragment` works great with `Dialog` and `Fragment`. 
<br>But `DialogFragment` is not always working stable.
Scenes like: 
* Try to show DialogFragment when Activity or Fragment has been destroyed or state-saved, which will throws IllegalStateException, like
    * Can not perform this action after onSaveInstanceState.
    * fragment {xxx} not associated with a fragment manager.
* DialogFragment can't work well with in-layout Fragments, which cause IllegalArgumentException, like
    * Binary XML file line #30: Duplicate id 0x7f080047.
* Sometimes DialogFragment cause memory leaks.


## Stargazers over time

[![Stargazers over time](https://starchart.cc/bytebeats/RobustDialogFragment.svg)](https://starchart.cc/bytebeats/RobustDialogFragment)

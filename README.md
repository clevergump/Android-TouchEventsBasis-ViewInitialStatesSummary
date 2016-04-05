控件默认的 enabled / clickable / longClickable / focusable / focusableInTouchMode / focused 情况:

 \ | enabled | clickable | longClickable | focusable | focusableInTouchMode | focused
:---|:---:|:---:|:---:|:---:|:---:|:---:
Button | true | **true** | false | **true** | false | false
TextView | true | false | false | false | false | false
<font color="red">**EditText**</font> | true | **true** | **true** | **true** | **true** | false
ImageView | true | false | false | false | false | false
LinearLayout | true | false | false | false | false | false
RelativeLayout | true | false | false | false | false | false
FrameLayout | true | false | false | false | false | false
ListView | true | **true** | false | false | false | false
GridView | true | **true** | false | false | false | false
ViewPager | true | false | false | **true** | false | false
RecyclerView | true | false | false | **true** | **true** | false
simplest CustomView   (最普通的自定义控件)| true | false | false | false | false | false
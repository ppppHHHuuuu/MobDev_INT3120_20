# Week 3

## View & Layout
### Linear Layout
* Is a GroupView
* Lay child View elements vertically or horizontally
* Attributes
    * android:orientation="horizontal"
    * Fill Model
        * Bắt buộc khai báo thuộc tính kích thước cho một Linear Layout
    * Weight
        * android:layout_weight: Tỉ lệ tương ứng để làm đầy view
    * Gravity
        * default: top left
        * android:layout_gravity: view position outside itself (Box of TextView)
        * android:gravity: arrange content inside the view (the text itself)
    * Margin & Padding
        * android:layout_margin=cách lề ngoài
        * android:layout_padding=cách lề bên trong

### Relative Layout
* Is a GroupView
* Lay child elements relatively to its parents or siblings
* Example: to right 10dp and down 30dp of its parent

### Absolute Layout
* Is a GroupView
* Directly place Views inside the layout by its own (x, y, z) in px
### Table Layout
* Is a GroupView
* Contain GroupView (Table Row), Table Row contains View(Buttons, etc..)
* Lay children into rows and columns
### Constraint Layout
* Drag and Drop View, ViewGroup

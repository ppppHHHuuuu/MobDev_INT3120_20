# Week2

## Android Project Structure
* java folder: write Java, Kotlin source code
* res folder: including resources folder
    * drawable folder: images here
    * layout: code layout like .html here
    * mipmap: your app icons
    * values: definitions for chuỗi, màu, style here
    *
* manifests folder: store AndroidManifest.xml
    * information the system write before anything of application's code
        * Declare Activity
        * Android version
        * theme
        * Authorize: allowBackup, supportRtl
* Gradle Scripts:
    * Build.gradle (Proj): Top-level build file where you can add configuration options common to all sub-projects/modules.
        * _**buildscript:**_ This block is used to configure the repositories and dependencies for Gradle.
    * Build.gradle (app): declare **dependencies** and **SDK versions** here

## Android Components
### Activity
* MainActivity.java (~JS) call the res/layout/activity_main.xml (~HTML)
* Acted as a window~screen ~forms
* Many Activities in an app, first one is MainActivity (changable)
#### Lifecycle State
		First is to create an activity with onCreate()
		An activity onStart() comes in and keep onResume() until another activity comes in front of the activity.
		in the next stage, onPause() is called as the activity still active its UI and showable to user (split screen), by the next task the activity may come back to the foreground or be killed by memory distribution for other apps
		onStop() is called when the activity is no longer visible to the user. this state is used for stopping animations (onDestroy()) and refreshing the UI(onRestart()), etc.
#### Steps
1. new Activity class extend AppCompatActivity
2. create xml file for layout in res/layout
3. Declare Activity in AndroidManifest.xml
4. Create functional for state of this Activity (onCreate(),....)



### View

* Layout component
* Usage: Interact with user (display information, ...)

#### Type
* View: đơn lẻ View Components (TextView, Button, CheckBox,...)
* ViewGroup: Contraint Layout, Linear Layout
* Attributes:
    * layout_width
    * layout_height
    * layout_marginTop
* View Component inside ViewGroup

### Service
* Ví dụ: Playing music in the background
* Attributes:
    * Need times,
    * chế độ ngầm,
    * không cần giao diện hiển thị
### Broadcast Receiver

* Types
    * Hệ thống: Truyền trực tiếp từ hệ thống
        * Ví dụ: Send user his phone low battery
    * Ứng dụng: khởi động service, tải nội dung
    * 
### Content Provider
* Usage: Truy cập tập hợp các dữ liệu ứng dụng: tệp tin, SQLite, tài nguyên Web, danh bạ, tài nguyên đa tài nguyên
* Tương tác với data từ ứng dụng khác, SQL lite,
### Notification
* Usage: Gửi thông báo tới người dùng, 
    * CÓ thể qua thanh trạng thái
    ss với Broadcast Receiver: Thông báo dễ dàng, không vừa nghe vừa phản hồi (Ex: Pin yếu)

### Intent
* Vận chuyển các message giữa các component ()
* Usage: Tạo yêu cầu giữa các thành phần trong ứng dụng, giữa các ứng dụng: khởi động Activity, khởi động Service
    * Ví dụ: Gọi mở window Activity2 từ Activity 1
        Tại sao lại không chuyển thẳng giữa 2 activity mà phải qua Android System
        - Android System sẽ check intent-filter của Activity 1 xem có Activity 2 trong đó không

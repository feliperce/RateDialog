# RateDialog

![MIT](https://img.shields.io/github/license/feliperce/RateDialog.svg)
[![JitPack](https://jitpack.io/v/feliperce/RateDialog.svg)](https://jitpack.io/#feliperce/RateDialog)

RateDialog is a Kotlin library to easily make "rate this app" dialog.

![RateDialog](https://i.imgur.com/bVgI3W9.png)

# Getting Started
**Step 1.** Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

**Step 2.** Add the dependency
```groovy
dependencies {
  implementation 'com.github.feliperce:RateDialog:Tag'
}
```

# Usage

Where do you want the dialog to start:

```kotlin
RateDialog(this)
  .setDays(4) // Default is 7
  .setLaunchTimes(3) // Default is 7
  .setDialogOptions(DialogOption()) // Optional
  .setPlaystorePackageName("mypackage") // Optional, dialog will use your app package name if you no set
  .create() // Create the dialog if the conditions are met, IMPORTANT: Always set the create() method last
```
Or you can easily set with one line code and the Dialog will use the default configurations:

```kotlin
RateDialog(this).create()
```

You can customize some Dialog configurations with DialogOptions and pass it in ```.setDialogOptions(dialogOptions)```:

```kotlin
val option = DialogOption().apply { 
  title = "My Dialog Title" // Dialog title, empty will use the default
  msg = "My dialog Message" // Dialog message, empty will use the default
  cancelable = false // Make the dialog cancelable, default is false
  hasNegativeButton = true // Show negative button, default is true
  hasNeutralButton = true // Show neutral button, default is true
  neutralButtonText = "Remind me later" // Neutral button text, empty will use the default
  positiveButtonText = "Rate it" // Positive button text, empty will use the default
  negativeButtonText = "No, thanks." // Negative button text, empty will use the default
}

// Create the dialog with custom options
RateDialog(this)
.setDialogOptions(option)
.create()
```

# Language and Support

* Currently supported only English and Brazilian portuguese, please help me with new translations by opening new PR.
* Support Android API 15+
* Kotlin and Java support

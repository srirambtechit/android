# android

## Android OS flashing and rooting step by step guide
### mobile setup
- enable developer option
- enable usb debugging

### packages, util software download
- usb_driver
- adb fastboot files
- os package
-  superuser package
- goolge apps package

### connect phone via usb cable in system
 - go to device manager to install usb_driver
 - make sure OS detects your mobile in device manager

### unlock bootloader
- have to find approach in google for specific mobile model
- open cmd
- go to adb folder in cmd
  ___$ fastboot oem device-info__
    ...
    (bootloader)    Device tampered: false
    (bootloader)    Device unlocked: true
    (bootloader)    Charger screen enabled: true
    (bootloader)    Display panel:
    OKAY [  0.020s]
    finished. total time: 0.022s___
- from the above output, you can find bootloader unlocked is true

### flashing phone
 - open cmd
 - go to adb folder in cmd
  ___$ adb devices__
    List of devices attached
    50dcbb38        device

  ___$ adb reboot bootloader__
   - it restarts the phone and display fastboot mode in mobile.

  ___$ fastboot flash recovery twrp-3.0.2-2-kenzo.img__
    - loads the recovery image into mobile

  ___$ fastboot boot twrp-3.0.2-2-kenzo.img__
    downloading 'boot.img'...
    OKAY [  1.318s]
    booting...
    OKAY [  0.505s]
    finished. total time: 1.829s

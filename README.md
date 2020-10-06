# FlutterGallery 
## Enviroment
- Android Studio Emulator, Device name: Pixel 3A API 28
- languange : java
- IDE: Intellij, install cucumber plugin (file > settings > plugin)
![plugin](https://i.ibb.co/PxJDJFF/cucumber-plugin.png)
- java version "1.8.0_111", Java(TM) SE Runtime Environment (build 1.8.0_111-b14), Java HotSpot(TM) 64-Bit Server VM (build 25.111-b14, mixed mode)
- appium 1.17.0
- cucumber 6.0.8
 
 ## How to run the script?
 1. Open Appium Desktop
 2. Start server
 
 ![appium](https://i.ibb.co/Z1Z9bTN/appium.png)
 
 3. Open Android emulator and install the flutter Gallery Apk
 4. Open the IDE
 5. Click FlutterGaller > scr > test > java > features > choose one of the features that want to run > click right > run feature '......'
 ![running feature](https://i.ibb.co/nkTrQcy/running-feature.jpg)
 
 ## assumption
 - feature that I create
 1. Adding item to shopping cart
 2. Clear shopping cart
 3. remove shopping cart
 
- There is a case when I choose one of the filter and I want to select one of the item then the element is not exist, so I create a solve that I create a function for refresh a screen by click the icon menu twice.
- when I add, clear and also remove the item from shopping cart I created 2 validation: 
1. first validate the item using view button using xpath
2. Second validate the item from Total shopping cart, i get the atribute from the xpath content-desc, after that i substring the text and convert data type to double and then i compare the data 
  
 
 

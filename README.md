# FlutterGallery 
## Enviroment
- Android Studio Emulator, Device name: Pixel 3A API 28
- Languange : Java
- IDE: Intellij, install cucumber plugin (file > settings > plugin)
![plugin](https://i.ibb.co/PxJDJFF/cucumber-plugin.png)
- Java version "1.8.0_111", Java(TM) SE Runtime Environment (build 1.8.0_111-b14), Java HotSpot(TM) 64-Bit Server VM (build 25.111-b14, mixed mode)
- Appium 1.17.0
- Cucumber 6.0.8
 
 ## How to run the script?
 1. Open Appium Desktop
 2. Start server
 
 ![appium](https://i.ibb.co/Z1Z9bTN/appium.png)
 
 3. Open Android emulator and install the flutter Gallery Apk
 4. Open the IDE (i use intellij)
 5. Click FlutterGaller > scr > test > java > features > choose one of the features that want to run > click right > run feature '......'
 ![running feature](https://i.ibb.co/nkTrQcy/running-feature.jpg)
 
 ## Assumption
 - Feature that I created
 1. Adding item to shopping cart
 2. Clear shopping cart
 3. Remove shopping cart
 
- There is a case when I choose one of the filter and I want to select one of the item then the element is not exist, to solve the problem I create a function for refresh the screen by click the icon menu twice.
- when I add, clear and also remove the item from shopping cart I created 2 validation: 
1. First validate the item using view button using xpath
2. Second validate the item from Total shopping cart, i get the atribute from the xpath content-desc, after that i substring the text and convert the data type to double and then i compare the data 
  
 
 

# AndroidEssentials
AndroidEssentials is  an android library that creates helper functions for performing common tasks in Android
such as managing preferences, managing files, showing alerts, showing toasts, checking user country & checking network connection of users.
All the methods of the class are static and should be accessed directly from the AndroidEssentials class.

## Language

Kotlin

## Installation

**Gradle**

1.  Add it in your root build.gradle at the end of repositories:
   ```
   allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  **NB** As of gradle 7.x.x allprojects has been [depreciated](https://stackoverflow.com/questions/69468492/how-can-i-add-jitpack-io-as-a-repository-in-my-build-gradle-correctly) in favor of Dependency Resolution Management. Go to settings.gradle and add the jitpack.io repository
  
  ```
  dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
       
        // e.g this is how you would add jitpack
        maven { url "https://jitpack.io" }
        
    }
}
  ```
 
 2. Add the dependency
   ```
   dependencies {
	        implementation 'com.github.IsaacSichangi:AndroidEssentials:v1.0.1'
	}
   ```
   **Maven**
   
   1. Add the JitPack repository to your build file
   
   ```
   <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
  ```
  2. Add the dependency
  ```
  <dependency>
	    <groupId>com.github.IsaacSichangi</groupId>
	    <artifactId>AndroidEssentials</artifactId>
	    <version>v1.0.1</version>
	</dependency>
  
   ```


### Preferences

```
AndroidEssentials.storeValueString(context: Context, key: String?, value: String?, app_name: String)

AndroidEssentials.storeValueDouble(context: Context, key: String?, value: Double, app_name: String)

AndroidEssentials.storeValueInt(context: Context, key: String?, value: Int, app_name: String)

AndroidEssentials.storeValueLong(context: Context, key: String?, value: Long, app_name: String)

AndroidEssentials.storeValueBoolean(context: Context, key: String?, value: Boolean, app_name: String)

AndroidEssentials.getValueBoolean(context: Context, key: String?, app_name: String):Boolean

AndroidEssentials.getValueInt(context: Context, key: String?, app_name: String):Int

AndroidEssentials.getValueDouble(context: Context, key: String?, app_name: String):Double

AndroidEssentials.getValueLong(context: Context, key: String?, app_name: String):Long

AndroidEssentials.getValueString(context: Context, key: String?, app_name: String):String

AndroidEssentials.clearValues(context: Context, app_name: String)

AndroidEssentials.deleteValue(context: Context, key: String?, app_name: String) 
      
```
### File Management
```
AndroidEssentials.checkFileExistence(context: Context, filename: String):Boolean
       
AndroidEssentials.storeFile(title: String, contents: String?, context: Context):Boolean
       
AndroidEssentials.getFileContents(filename: String, context: Context):String

AndroidEssentials.deleteFile(title: String, context: Context)

 ```
 ### Get User Country Code
 ```
 AndroidEssentials.getUserCountry(context: Context):String
 ```
 
 ### Check Network Connection
 
 ```   
 AndroidEssentials.checkConnection(context: Context): Boolean 
 ```
 
 ### Show Alert & Toast
 
 ```
 AndroidEssentials.showToast(context: Context?, message: String?)
   
 AndroidEssentials.showAlert(activity: AppCompatActivity, message: String?)
 ```
           





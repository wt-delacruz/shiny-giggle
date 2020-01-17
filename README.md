# shiny-giggle
This sandbox attempts to evaluate different solutions for a mobile test automation framework.
The automation driver is Appium (appium.io) and the test runner is TestNG.

# Getting Started:

Make sure you've set the following environment variables in your ~/.bash_profile file:
- `NODE_PATH`: Path to where your node executable is stored. 
```shell script
export NODE_PATH="/$HOME/.nvm/versions/node/v12.14.0/bin/node"
```
- `APPIUM_SERVER_PATH`: Path to where your Appium NPM package is stored.
```shell script
export APPIUM_SERVER_PATH="/$HOME/.nvm/versions/node/v12.14.0/bin/appium"
```
This is so we can start an Appium server instance for you. Any available port will be used.

Suggestion: Use [NVM](https://github.com/nvm-sh/nvm) to manage your NodeJS versions.

Additionally make sure you have the following AVDs installed:

Device Name | Model | Resolution | Google APIs | OS Release Name |
----------- | ----- | ---------- | ----------- | --------------- |
Pixel_3_XL_API_29 | Pixel 3 XL | 1400x2160, 560dpi | Android 10.0 | Android Q |
Pixel_3A_XL_API_29 | Pixel 3a XL | 1080x2160, 400dpi | Android 10.0 | Android Q |

Lastly, make sure `appium-doctor` checks are green for what you need.

# Execution:
Test are executed by running `mvn install` or, since they are organized by suites, just execute the `resources/default.xml` file from your preferred IDE.


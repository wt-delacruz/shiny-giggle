# shiny-giggle
This is a sandbox in attempt to evaluate different solutions for a mobile test automation framework.
The automation driver is Appium (appium.io).

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

Suggestion: Use [NVM](https://github.com/nvm-sh/nvm) to manage your NPM packages.

# Execution:
Test are organized in suites so just execute the `test-suite-1.xml` file


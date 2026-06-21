@echo off
setlocal EnableExtensions
set MAVEN_VERSION=3.9.9
set WRAPPER_DIR=%~dp0.mvn
set MAVEN_HOME_DIR=%WRAPPER_DIR%\apache-maven-%MAVEN_VERSION%
set MVN_CMD=%MAVEN_HOME_DIR%\bin\mvn.cmd

if exist "%MVN_CMD%" goto run

echo Maven %MAVEN_VERSION% was not found locally. Downloading Maven for this project...
if not exist "%WRAPPER_DIR%" mkdir "%WRAPPER_DIR%"
powershell -NoProfile -ExecutionPolicy Bypass -Command "[Net.ServicePointManager]::SecurityProtocol=[Net.SecurityProtocolType]::Tls12; $url='https://archive.apache.org/dist/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.zip'; $zip=Join-Path '%WRAPPER_DIR%' 'apache-maven-3.9.9-bin.zip'; Invoke-WebRequest -Uri $url -OutFile $zip; Expand-Archive -Path $zip -DestinationPath '%WRAPPER_DIR%' -Force"
if errorlevel 1 (
  echo Could not download Maven automatically. Install Maven manually or run the project with Docker.
  exit /b 1
)

:run
call "%MVN_CMD%" %*

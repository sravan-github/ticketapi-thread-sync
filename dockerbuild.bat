@echo off
SET IMAGE_NAME=ticketapi-threadsync
SET IMAGE_TAG=1.0
SET DOCKER_USERNAME=sravanscker
cd pwd
echo Building Docker image...
docker build -t %DOCKER_USERNAME%/%IMAGE_NAME%:%IMAGE_TAG% .

IF %ERRORLEVEL% NEQ 0 (
    echo Build failed!
    exit /b 1
)

echo Pushing image to Docker Hub...
docker push %DOCKER_USERNAME%/%IMAGE_NAME%:%IMAGE_TAG%

IF %ERRORLEVEL% NEQ 0 (
    echo Push failed!
    exit /b 1
)

echo Done: %DOCKER_USERNAME%/%IMAGE_NAME%:%IMAGE_TAG%

#!/usr/bin/env sh
set -e
MAVEN_VERSION="3.9.9"
BASE_DIR="$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)"
WRAPPER_DIR="$BASE_DIR/.mvn"
MAVEN_HOME_DIR="$WRAPPER_DIR/apache-maven-$MAVEN_VERSION"
MVN_CMD="$MAVEN_HOME_DIR/bin/mvn"

if [ ! -x "$MVN_CMD" ]; then
  echo "Maven $MAVEN_VERSION was not found locally. Downloading Maven for this project..."
  mkdir -p "$WRAPPER_DIR"
  ZIP_FILE="$WRAPPER_DIR/apache-maven-$MAVEN_VERSION-bin.zip"
  if command -v curl >/dev/null 2>&1; then
    curl -L "https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.zip" -o "$ZIP_FILE"
  elif command -v wget >/dev/null 2>&1; then
    wget "https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.zip" -O "$ZIP_FILE"
  else
    echo "curl or wget is required to download Maven. Install Maven manually or run the project with Docker."
    exit 1
  fi
  if command -v unzip >/dev/null 2>&1; then
    unzip -q "$ZIP_FILE" -d "$WRAPPER_DIR"
  else
    echo "unzip is required to extract Maven. Install Maven manually or run the project with Docker."
    exit 1
  fi
  chmod +x "$MVN_CMD"
fi

exec "$MVN_CMD" "$@"

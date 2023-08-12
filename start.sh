sudo pacman -Syu docker docker-compose
sudo pacman -S jdk-openjdk
javac FlaskClient.java
docker-compose up -d
java FlaskClient

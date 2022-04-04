# Shutting down the containers
echo "Shutting down all containers"
docker-compose down --remove-orphans
# Delete all containers using the following command:
echo "Deleting all containers"
docker rm -f $(docker ps -a -q)
#Delete all volumes using the following command:
echo "Deleting all volumes"
docker volume rm $(docker volume ls -q)

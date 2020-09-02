cd ./backend/import
./mvnw clean package -Dmaven.test.skip=true
cd ../export
./mvnw clean package -Dmaven.test.skip=true
cd ../../frontend/import
npm ci
ng update
ng build --prod
cd ../export
npm ci
ng update
ng build --prod
docker-compose up

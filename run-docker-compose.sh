positive="compiled successfully"
negative="not compiled!"

importBackend=$negative
exportBackend=$negative
importFrontend=$negative
exportFrontend=$negative

cd ./backend/import
./mvnw clean package -Dmaven.test.skip=true && importBackend=$positive
cd ../export
./mvnw clean package -Dmaven.test.skip=true && exportBackend=$positive
cd ../../frontend/import
npm ci && ng update && ng build --prod && importFrontend=$positive
cd ../export
npm ci && ng update && ng build --prod && exportFrontend=$positive

echo "Import frontend $importFrontend"
echo "Export frontend $exportFrontend"
echo "Import backend $importBackend"
echo "Export backend $exportBackend"

docker-compose up

Building:

	For building Java1.8 sdk and maven is required.

	"./mvn clean package -Dmaven.test.skip=true"


Info:
	The BackendExporter is listen to:
		/province (PUT)
			To update the informations of the given province.
		/buildningType (POST)
			To add a new BuilingType

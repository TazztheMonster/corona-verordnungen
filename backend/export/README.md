Building:

	For building Java1.8 sdk and maven is required.

	"./mvn clean package -Dmaven.test.skip=true"


Info:
	The BackendExporter is listen to:
		/provinces (GET)
			Returns a list of all Provinces.
		/buildningTypes (GET)
			Returns a list of all BuildingTypes.
		/province/{province} (GET)
			Returns all informations of the given province.

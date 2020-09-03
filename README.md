Requirements:
	JavaSDK 1.8 or higher
	NPM
	NG
	Docker
	docker-compose

How to run:
	Linux:
		Just run the "run-docker-compose.sh". It compiles the Front and backends for you.
		After that it run's "docker-compose up"
	
		Alternative:
			You can do the steps for Windows.
	
	Windows:
		Run "/mvnw clean package -Dmaven.test.skip=true" inside the backend projects.
		Run "npm ci && ng update && ng build" inside the frontend projects.
		Run "docker-compose up" in this root folder.

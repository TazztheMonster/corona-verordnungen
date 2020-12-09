Das hier ist das Ergebniss einer Zwischenprüfung mit wenig Zeit.
Der Funktionsumpfang und die Nutzbarkeit ist sehr eingeschränkt und soll nur zu "Vorstellungs zwecken" dienen.



Requirements:
	JavaSDK 1.8 or higher,
	NPM,
	NG,
	Docker,
	docker-compose

How to run:
	Linux:
		Just run the "run-docker-compose.sh". It compiles the Front and backends for you.
		After that it run's "docker-compose up"
	
		Alternative:
			You can do the steps for Windows.
	
	Windows:
		Run "/mvnw clean package -Dmaven.test.skip=true" inside each backend projects.
		Run "npm ci && ng update && ng build" inside each frontend projects.
		Run "docker-compose up" in this root folder.


How to use:
	Access the website for importing data:
		http://localhost:8080
			logindata:
				user: admin
				password: admin
	Access the public website
		http://localhosst:8081


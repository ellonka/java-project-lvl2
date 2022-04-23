install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app

check-updates:
	./gradlew dependencyUpdates

lint:
	./gradlew checkstyleMain

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

build: lint test
	./gradlew clean build

run-simple-json:
	./build/install/app/bin/app ./src/test/resources/file1.json ./src/test/resources/file2.json

run-simple-yml:
	./build/install/app/bin/app ./src/test/resources/file1.yml ./src/test/resources/file2.yml

run-complex-json:
	./build/install/app/bin/app ./src/test/resources/file3.json ./src/test/resources/file4.json

run-complex-yml:
	./build/install/app/bin/app ./src/test/resources/file3.yml ./src/test/resources/file4.yml

run-plain-format:
	./build/install/app/bin/app -f plain ./src/test/resources/file3.json ./src/test/resources/file4.json

.PHONY: build
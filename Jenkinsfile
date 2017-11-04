pipeline {
	agent any

	stages {
		stage ('Compile Stage') {
			steps {
				withMaven(maven : 'maven_3_3_9') {
					sh 'mvn clean compile'
				}
			}
		}

		stage ('Testting Stage') {
			steps {
				withMaven (maven : 'maven_3_3_9') {
					sh 'mvn test'
				}
			}
		}

		stage ('Deployment Stage') {
			steps {
				withMaven (maven : 'maven_3_3_9') {
					sh 'mvn deploy'
				}
			}
		}
	}
}
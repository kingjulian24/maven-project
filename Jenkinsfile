pipeline {
	agent any 

	stages {
		stage('Build') {
			steps {
				sh 'mvn clean package'
			}

			post {
				success {
					echo 'Now archiving...'
					archiveArtifacts artifacts: '**/target/*.war'
				}
			}
		}
		stage('Deploy to Staging') {
			steps {
				build job: 'Deploy-to-staging'
				build job: 'static analysis'
			}
		}
		stage('Deploy to Production') {
			steps {
				timeout(time:5, unit: 'DAYS') {
					input message: 'Approve PRODUCTION Deployment?'
				}

				build job: 'deploy-to-prod'
			}
			post {
				success {
					echo 'Code deployed to Production.'
				}

				failure {
					echo 'Deployment to Production failed.'
				}
			}
		}
	}
}
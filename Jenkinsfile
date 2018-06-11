pipeline {
	agent any 

	stages {
		stage('Build') {
			steps {
				sh 'export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home'
				sh 'export M2_HOME=/opt/maven'
				sh 'mvn clean package'
			}

			post {
				success {
					echo 'Now archiving...'
					archiveArtifacts artifacts: '**/target/*.war'
				}
			}
		}
	}
}
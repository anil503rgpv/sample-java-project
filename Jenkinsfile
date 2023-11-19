pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven3"
    }

    stages {
        /* stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git credentialsId: 'github-credential', url: 'git@github.com:anil503rgpv/sample-java-project.git'

                // Run Maven on a Unix agent.
                sh "mvn clean install"
            }


            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**//* target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target *//*.jar'
                }
            }
        } */
        stage('SCM') {
            checkout scm
          }
          stage('SonarQube Analysis') {
            def mvn = tool 'maven3';
            withSonarQubeEnv() {
              sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=anil503rgpv_sample-java-project_AYvl0QZq3bvwGHI8qXIb"
            }
          }
    }
}

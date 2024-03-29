node {
    // holds reference to docker image
    def dockerImage
    // ip address of the docker private repository(nexus)
    
    def dockerRepoUrl = "https://hub.docker.com/r/zenardi/"
    def dockerImageName = "springmvc"
    def dockerImageTag = "${dockerRepoUrl}/${dockerImageName}:${env.BUILD_NUMBER}"
     
    stage ("Get Source") {
        // run a command to get the source code download
        sh "git pull https://github.com/Zenardi/springboot-mvc.git"
        
    }
  
    stage('Build Project') {
      // build project via maven
      sh "mvn clean package"
    }
	

	stage('DockerLint'){
	 sh "docker run --rm -i hadolint/hadolint < Dockerfile"	
	}
	
	
    stage('Build Docker Image and Push') {
       // build docker image
       docker.withRegistry('https://registry.hub.docker.com', 'docker') {	
           dockerImage = docker.build("zenardi/springmvc")
           /* Push the container to the custom Registry */
           dockerImage.push()
       }
    }

    stage('Deploying K8S') {
      echo 'Deploying to AWS...'
      dir ('./terraform/app') {
        withAWS(credentials: 'aws-credentials', region: 'us-west-2') {
            //sh 'kubectl rolling-update springmvc -f web.yaml'
            sh 'kubectl set image deployment/ns springmvc=zenardi/springmvc:latest --record'
        }
      }
    }

}

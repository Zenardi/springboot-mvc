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
	
    stage('Build Docker Image') {
      // build docker image
      dockerImage = docker.build("zenardi/springmvc")
    }
   
    stage('Deploy Docker Image'){
      
      // deploy docker image to nexus
       //echo "Docker Image Tag Name: ${dockerImageTag}"
       //sh "docker tag ${dockerImageName} ${dockerImageTag}"
       //sh "docker push ${dockerImageTag}"
	       
       docker.withRegistry('https://registry.hub.docker.com', 'dockerlogin') {
          app.push("${env.BUILD_NUMBER}")
          app.push("latest")
       }		
    }
}

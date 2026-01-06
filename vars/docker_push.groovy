def call(String ProjectName, String ImageTag){
  withCredentials([usernamePassword(credentialsId:"dockerHubCred",passwordVariable:"dockerHubPass", usernameVariable:"dockerHubUser")]) 
  {
    sh """
          echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin

          docker tag ${ProjectName}:${ImageTag} $dockerHubUser/${ProjectName}:${ImageTag}
          
          docker push $dockerHubUser/${ProjectName}:${ImageTag}
      """
    }
}

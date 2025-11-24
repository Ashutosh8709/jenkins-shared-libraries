def call(){
  withCredentials([usernamePassword(credentialsId:"dockerHubCred",passwordVariable:"dockerHubPass", usernameVariable:"dockerHubUser")]) 
  {
    sh '''
          echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin

          docker tag ecommerce-backend:latest $dockerHubUser/ecommerce-backend:latest
          docker tag ecommerce-frontend:latest $dockerHubUser/ecommerce-frontend:latest

          docker push $dockerHubUser/ecommerce-backend:latest
          docker push $dockerHubUser/ecommerce-frontend:latest
      '''
    }
}

def call() {
        sh '''
        docker exec trivy \
          trivy fs \
          --severity HIGH,CRITICAL \
          --exit-code 1 \
          /workspace/EcommerceCI
        '''
}

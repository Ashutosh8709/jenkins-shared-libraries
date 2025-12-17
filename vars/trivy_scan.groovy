def call() {
        sh '''
        docker exec trivy trivy fs \
          --severity HIGH,CRITICAL \
          --exit-code 1 \
          --skip-dirs node_modules,vendor,.git \
          "$WORKSPACE"
        '''
}

def call() {
        sh '''
          trivy fs \
            --severity HIGH,CRITICAL \
            --exit-code 1 \
            --skip-dirs node_modules,vendor,.git \
            .
        '''
}

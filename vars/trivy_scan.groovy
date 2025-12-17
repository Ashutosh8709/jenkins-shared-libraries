def call() {
        sh '''
        trivy fs \
          --server http://host.docker.internal:4954 \
          --severity HIGH,CRITICAL \
          --exit-code 1 \
          .
}

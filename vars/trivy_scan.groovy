def call() {
    sh '''
    docker run --rm \
      -v "$WORKSPACE:/project" \
      aquasec/trivy fs \
      --severity HIGH,CRITICAL \
      --exit-code 1 \
      /project
    '''
}

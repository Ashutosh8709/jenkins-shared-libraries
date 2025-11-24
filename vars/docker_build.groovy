def call(String projectName, String imageTag, String file){
  sh "docker build -t ${projectName}:${imageTag} -f ${file}/Dockerfile ${file}"
}

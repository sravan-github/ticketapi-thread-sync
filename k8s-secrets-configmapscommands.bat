kubectl apply -f Secret.yml
kubectl apply -f ConfigMap.yml
kubectl apply -f springboot-deployment.yml
timeout /t 5 /nobreak >nul
kubectl port-forward service/springboot-service 8080:80
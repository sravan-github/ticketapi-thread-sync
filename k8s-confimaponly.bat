kubectl apply -f configmap-sp.yml
kubectl apply -f deployment.yml
timeout /t 5 /nobreak >nul
kubectl port-forward service/springboot-service 8080:80
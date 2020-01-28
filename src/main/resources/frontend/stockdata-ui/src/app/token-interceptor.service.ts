import { Injectable , Injector} from '@angular/core';
import { HttpInterceptor } from "@angular/common/http";
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor{

  constructor(private injector : Injector) { }

  intercept(request, next){
    let authService = this.injector.get(AuthService);
    console.log("request-url: "+request.url);
    if(request.url === 'http://localhost:8080/authenticate' || request.url === 'http://localhost:8080/register'){
      return next.handle(request);
    }
    let tokenizedRequest = request.clone({
      setHeaders : {
        Authorization : `Bearer ${authService.getToken()}`
      }
    })
    return next.handle(tokenizedRequest);
  }
}

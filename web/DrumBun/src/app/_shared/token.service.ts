export class TokenService{
  public token: string;

  getToken(){
    return this.token;
  }

  setToken(token: string){
    this.token = token;
  }

  isAuthenticated() {
    return this.token != null;
  }

}

package Http;

/**
 * 说 明：列举所有的http返回的状态
 * Created by wuzhu on 2017/3/6.
 */
public enum HTTP_CODE {
    //1xx：指示信息，表示请求已接收，继续处理

    //2xx：成功，表示请求已被成功接收
    HTTP_OK(200,"请求成功"),
    HTTP_OK_CREATED(201,"成功请求并创建了新资源"),
    HTTP_OK_ACCEPT(202,"已接受请求"),
    HTTP_OK_UNAUTH(203,"非授权信息，请求成功"),
    HTTP_OK_NO_CONTENT(204,"服务器请求成功，但未返回内容"),

    //3xx：重定向，要完成请求必须进行更进一步操作
    HTTP_REDIRECTION(301,"资源被永久转移到其他URL"),

    //4xx：客户端错误，请求有语法错误或请求无法实现
    HTTP_CLIENT_BADQER(400,"客户端请求有语法错误，不能被服务器理解"),
    HTTP_CLIENT_UNAUTH(401,"请求未经授权"),
    HTTP_CLIENT_FOBIDDEN(403,"服务器收到请求，但是拒绝提供服务"),
    HTTP_CLIENT_NOTFOUND(404,"请求资源不存在，输入了错误的URL"),
    HTTP_CLIENT_METHOD_NOTALLOWED(405,"客户端请求的方法被禁止"),
    HTTP_CLIENT_TIME_OUT(408,"服务器等待客户端发送的请求时间过长，超时"),

    //5xx：服务器端错误，服务器未能实现合法的请求
    HTTP_SERVER_SERVER_ERR(500,"服务器发生不可预期的错误"),
    HTTP_SERVER_NOT_IMPLEMENTED(501,"服务器不支持请求的功能，无法完成请求"),
    HTTP_SERVER_BAD_GATEWAY(502,"充当网关或代理的服务器，从远端服务器接受到了一个无效的请求"),
    HTTP_SERVER_UNAVAILABLE(503,"服务器当前不能处理客户端请求"),
    HTTP_SERVER_GATEWAY_TIMEOUT(504,"充当网关或代理的服务器，未及时从远端服务器获取请求"),
    HTTP_SERVER_VERTION_NOTSUPPORTED(505,"服务器不支持请求的HTTP协议的版本");

    private int code;
    private String des;

    HTTP_CODE(Integer code,String des){
        this.code = code;
        this.des = des;
    }
}

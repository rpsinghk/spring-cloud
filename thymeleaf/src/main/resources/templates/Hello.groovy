
@RestController("/h")
class ThisWillActuallyRun {

    @RequestMapping("/hello")
    String home() {
        return "Hello World!"
    }

}
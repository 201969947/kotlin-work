// COMP2850 Portfolio: Week 2
// Function to redact sensitive information in a string
fun redact(document: String, textToRedact: String, redactChar: Char = 'X'): String {


    val mask = redactChar.toString().repeat(textToRedact.length)

    return document.replace(textToRedact, mask)
}

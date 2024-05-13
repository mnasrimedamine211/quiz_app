$(document).ready(function() {
    // Fetch quiz data when the page loads
    fetchQuiz();

    // Event listener for submitting the quiz
    $('#quizContainer').on('click', '#submitQuiz', function() {
        submitQuiz();
    });
});

function fetchQuiz() {
    $.ajax({
        url: 'quiz', // Adjust if your endpoint is different
        type: 'GET',
        success: function(response) {
            // Assuming response is the quiz object with questions
            var quiz = JSON.parse(response);
            var htmlContent = '';
            quiz.questions.forEach(function(question, index) {
                htmlContent += '<div>';
                htmlContent += '<p><b>Question ' + (index + 1) + ':</b> ' + question.text + '</p>';
                question.options.forEach(function(option, idx) {
                    htmlContent += '<input type="radio" name="question' + index + '" value="' + option + '">' + option + '<br>';
                });
                htmlContent += '</div>';
            });
            htmlContent += '<button id="submitQuiz">Submit</button>';
            $('#quizContainer').html(htmlContent);
        },
        error: function() {
            $('#quizContainer').html('<p>Error loading quiz. Please try again later.</p>');
        }
    });
}

function submitQuiz() {
    var answers = [];
    var questions = $('#quizContainer div');

    questions.each(function(index, element) {
        var selectedOption = $('input[name="question' + index + '"]:checked', element).val();
        if (selectedOption) {
            answers.push({ questionIndex: index, answer: selectedOption });
        } else {
            answers.push({ questionIndex: index, answer: "" }); // Handling non-answered questions
        }
    });

    // Now send this data to your server
    console.log("Collected answers:", answers); // Replace this with an AJAX request to submit answers
  
}

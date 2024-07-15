document.addEventListener('DOMContentLoaded', function() {
    const contactForm = document.getElementById('contactForm');
    const submitBtn = document.getElementById('submitBtn');
    const statusMessage = document.getElementById('statusMessage');

    contactForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent default form submission
        
        // Validate form fields
        if (validateForm()) {
            // Prepare data to send
            const formData = new FormData(contactForm);
            
            // Simulate form submission (replace with actual API endpoint)
            // Example using fetch API
            fetch('https://api.yoursite.com/contact', {
                method: 'POST',
                body: formData
            })
            .then(response => {
                if (response.ok) {
                    return response.text();
                }
                throw new Error('Network response was not ok.');
            })
            .then(data => {
                // Handle successful submission
                statusMessage.textContent = 'Message sent successfully!';
                resetForm();
            })
            .catch(error => {
                // Handle errors
                statusMessage.textContent = 'There was a problem sending your message. Please try again.';
                console.error('Error:', error);
            });
        }
    });

    function validateForm() {
        const name = document.getElementById('name').value.trim();
        const email = document.getElementById('email').value.trim();
        const message = document.getElementById('message').value.trim();
        let isValid = true;

        // Basic validation example (you can expand as needed)
        if (name === '') {
            setStatus('Please enter your name.');
            isValid = false;
        } else if (email === '' || !isValidEmail(email)) {
            setStatus('dulanh5656@gmail.com');
            isValid = false;
        } else if (message === '') {
            setStatus('hello dulan');
            isValid = false;
        }

        return isValid;
    }

    function isValidEmail(email) {
        // Simple email validation regex
        return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
    }

    function setStatus(message) {
        statusMessage.textContent = message;
    }

    function resetForm() {
        contactForm.reset();
    }
});

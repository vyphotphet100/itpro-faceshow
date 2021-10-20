class UserRequest {
    static logIn(username, password) {
        return $.ajax({
            url: Base.apiUrl + '/user/log-in',
            type: 'POST',
            async: false,
            contentType: 'application/json',
            data: JSON.stringify({
                username : username,
                password : password
            }),
            success: function(userDto) {
                return userDto;
            },
            error: function(error) {
                alert(error.responseJSON.message);
                return error;
            }
        }).responseJSON;
    }

    static createAccount(username, password, fullName) {
        return $.ajax({
            url: Base.apiUrl + '/user/create-account',
            type: 'POST',
            async: false,
            contentType: 'application/json',
            data: JSON.stringify({
                username : username,
                password : password,
                fullName : fullName
            }),
            success: function(userDto) {
                return userDto;
            },
            error: function(error) {
                alert(error.responseJSON.message);
                return error;
            }
        }).responseJSON;
    }

    static updateProfile(userDto) {
        return $.ajax({
            url: Base.apiUrl + '/user/update-profile',
            type: 'POST',
            async: false,
            contentType: 'application/json',
            data: JSON.stringify(userDto),
            success: function(userDto) {
                return userDto;
            },
            error: function(error) {
                alert(error.responseJSON.message);
                return error;
            }
        }).responseJSON;
    }

    static getProfile(username) {
        return $.ajax({
            url: Base.apiUrl + '/user/'+ username +'/get-profile',
            type: 'GET',
            async: false,
            contentType: 'application/json',
            success: function(userDto) {
                return userDto;
            },
            error: function(error) {
                alert(error.responseJSON.message);
                return error;
            }
        }).responseJSON;
    }

    static sendMessageToRoom(messageDto) {
        stompClient.send("/user/send-message-to-room", {}, JSON.stringify(
            {
                'content': 'xin chào',
                'roomId' : '1',
                'userUsername' : 'eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7InJvb21JZHMiOlsiMSIsIjIiXSwiYWRkcmVzcyI6IlRQSENNIiwiam9pbmVkUm9vbUlkcyI6W10sInJlcXVlc3RMaXN0IjpbXSwibWVzc2FnZUlkcyI6WzEsMl0sImZ1bGxOYW1lIjoiTmd1eWVuIFZhbiBBIiwiYXZhdGFyIjpudWxsLCJtZXNzYWdlIjpudWxsLCJ0b2tlbiI6IjMyMWNiYWZkc2ZkIiwicGFzc3dvcmQiOiIxMjM0NTYiLCJjcmVhdGVkRGF0ZSI6bnVsbCwicGhvbmUiOiIwMTIzNDU2Nzg5IiwiaHR0cFN0YXR1cyI6bnVsbCwibW9kaWZpZWREYXRlIjpudWxsLCJyZXN1bHRMaXN0IjpbXSwidXNlcm5hbWUiOiJ1c2VyMSIsInN0YXR1cyI6Ik9GRkxJTkUifX0.H-vnkqBLLo7qIs0CiyEI5wJT_PIfVPkoKxP4G6AsTi4'
            }
        ));
    }
}
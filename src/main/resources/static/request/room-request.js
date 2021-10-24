class RoomRequest {
    static getUserStatus(roomId) {
        return $.ajax({
            url: Base.apiUrl + '/room/' + roomId + '/get-user-status',
            type: 'GET',
            async: false,
            headers: { 'Authorization': 'Token ' + getCookie('token') },
            contentType: 'application/json',
            success: function(roomDto) {
                return roomDto;
            },
            error: function(error) {
                alert(error.responseJSON.message);
                return error;
            }
        }).responseJSON;
    }
}

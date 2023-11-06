const API_KEY = 'AIzaSyDXaIQC20l4IgsfoDnQFOuSnJhom-EguZU'
    const CALENDAR_ID = 'ja.japanese#holiday@group.v.calendar.google.com';

    function start() {
        //GoogleのAPI呼び出しリファレンスに従った初期処理
        gapi.client.init({
            'apiKey': API_KEY,
        }).then(function() {
            return gapi.client.request({
                'path': 'https://www.googleapis.com/calendar/v3/calendars/' + encodeURIComponent(CALENDAR_ID) + '/events'
            })
        }).then(function(response) {
            let resultArea = document.getElementById('resultArea');
            let items = response.result.items;
            for(let i = 0; i < items.length; i++){
                resultArea.insertAdjacentHTML('beforeend', items[i].summary + items[i].start.date + '<br>');
            }
        }, function(reason) {
        console.log('Error: ' + reason.result.error.message);
        });
    };
    gapi.load('client', start);
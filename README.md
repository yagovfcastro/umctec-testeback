# :hospital: UMC Tec's back end code challenge
This is my attempt on the UMC Tec's back end code challenge, in which I tried to make an API that would serve one of their screens.

It was, indeed, a challenge. I struggled to understand some concepts and maybe I haven't grasped them all just yet, but, it was also a great learning experience and for that I'm really thankful.

## :arrow_forward: What you'll need to build and run this project
The first thing you'll have to do here is install [Intellij IDEA](https://www.jetbrains.com/idea/download/#section=windows) (since I've used Kotlin for this project). Then you just have to clone this repository and import it as a maven project through Intellij's "import a project" option .

Having done that, all you got to do is run the TestBackUmcApplication file and thats it!

## :large_blue_diamond: Activities

- Activity **POST** route -> ```http://localhost:8080/activities```
- Body example:
```json
{
 "activityTitle": "Centro Cirúrgico",
 "activitySubTitle": "Organizar prontuário",
 "sla": 12
}
```

- Activity **GET** route -> ```http://localhost:8080/activities```
- Response example:
```json
[
  {
    "activityId": 1,
    "activityTitle": "Auditoria",
    "activitySubTitle": "Limpar Conta",
    "createdAt": "2020-11-02T10:01:04.63126",
    "sla": 8
  },
  {
    "activityId": 2,
    "activityTitle": "Berçário",
    "activitySubTitle": "Organizar prontuário",
    "createdAt": "2020-11-02T10:07:39.425998",
    "sla": 10
  },
  {
    "activityId": 3,
    "activityTitle": "Centro Cirúrgico",
    "activitySubTitle": "Organizar prontuário",
    "createdAt": "2020-11-02T10:07:43.211112",
    "sla": 12
  }
]
```

## :large_blue_diamond: Cards

- Card **POST** route -> ```http://localhost:8080/cards ```
- Body example:

```json
{
 "activityId": 1,
 "patient": {
	"patientId": 4593,
	"patientName": "Jorge"
 },
 "healthInsurance": {
	 "healthInsuranceId": 10,
	 "healthInsuranceName": "Inter Plena"
 },
 "bill": {
	 "billId": 2464,
	 "billType": "AMBULATORIAL",
	 "billPrice": 540.64,
	 "visitId": 2412
 },
 "numberofDependencies": 5,
 "numberOfOpenPendencies": 0,
 "numberOfDocuments": 10,
 "numberOfNotReceivedDocuments": 5,
 "numberOfChecklistItem": 10,
 "numberOfDoneChecklistItem": 10
}
```

- One of the many possible **GET** routes -> ```http://localhost:8080/cards?filter=TO_RECEIVE```
- Response example :
```json
{
  "cards": [
    {
      "cardId": 1,
      "activityId": 1,
      "slaStatus": "DELAYED",
      "createdAt": "2020-10-03T20:06:24.665182",
      "patient": {
        "patientId": 4593,
        "patientName": "Jorge"
      },
      "healthInsurance": {
        "healthInsuranceId": 10,
        "healthInsuranceName": "Inter Plena"
      },
      "bill": {
        "billId": 2464,
        "billType": "HOSPITALAR",
        "billPrice": 22.340,
        "visitId": 2482
      },
      "totalAmount": 22.340,
      "numberOfPendencies": 0,
      "numberOfOpenPendencies": 0,
      "numberOfDocuments": 10,
      "numberOfNotReceivedDocuments": 5,
      "numberOfChecklistItem": 10,
      "numberOfDoneChecklistItem": 10
    },
    {
      "cardId": 2,
      "activityId": 1,
      "slaStatus": "OK",
      "createdAt": "2020-11-03T20:06:23.960838",
      "patient": {
        "patientId": 4594,
        "patientName": "Maria"
      },
      "healthInsurance": {
        "healthInsuranceId": 10,
        "healthInsuranceName": "Inter Plena"
      },
      "bill": {
        "billId": 2829,
        "billType": "AMBULATORIAL",
        "billPrice": 540.97,
        "visitId": 2571
      },
      "totalAmount": 540.97,
      "numberOfPendencies": 0,
      "numberOfOpenPendencies": 0,
      "numberOfDocuments": 10,
      "numberOfNotReceivedDocuments": 5,
      "numberOfChecklistItem": 10,
      "numberOfDoneChecklistItem": 10
    },
    {
      "cardId": 3,
      "activityId": 1,
      "slaStatus": "OK",
      "createdAt": "2020-11-03T20:06:25.214842",
      "patient": {
        "patientId": 4593,
        "patientName": "Victor"
      },
      "healthInsurance": {
        "healthInsuranceId": 10,
        "healthInsuranceName": "Inter Plena"
      },
      "bill": {
        "billId": 2883,
        "billType": "AMBULATORIAL",
        "billPrice": 12.513,
        "visitId": 2758
      },
      "totalAmount": 12.513,
      "numberOfPendencies": 0,
      "numberOfOpenPendencies": 0,
      "numberOfDocuments": 10,
      "numberOfNotReceivedDocuments": 5,
      "numberOfChecklistItem": 10,
      "numberOfDoneChecklistItem": 10
    }
  ],
  "totalCardsOk": 2,
  "totalCardsWarning": 0,
  "totalCardsDelayed": 1
}
```





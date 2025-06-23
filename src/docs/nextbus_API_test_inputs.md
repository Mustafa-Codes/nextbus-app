# NextBus API - Test Input Combinations

This document provides test input combinations formatted for the custom endpoint:

```
/route/nextbus?route={routeLabel}&stop={stopDescription}&direction={direction}
```

URL parameters should be properly URL-encoded when testing in a browser or HTTP client.

---

## METRO Blue Line

### Northbound
- `/route/nextbus?route=METRO%20Blue%20Line&stop=Mall%20of%20America%20Station&direction=north`
- `/route/nextbus?route=METRO%20Blue%20Line&stop=VA%20Medical%20Center%20Station&direction=north`
- `/route/nextbus?route=METRO%20Blue%20Line&stop=Target%20Field%20Station%20Platform%202&direction=north`

### Southbound
- `/route/nextbus?route=METRO%20Blue%20Line&stop=Target%20Field%20Station%20Platform%202&direction=south`
- `/route/nextbus?route=METRO%20Blue%20Line&stop=Franklin%20Ave%20Station&direction=south`
- `/route/nextbus?route=METRO%20Blue%20Line&stop=Mall%20of%20America%20Station&direction=south`

---

## METRO Green Line

### Eastbound
- `/route/nextbus?route=METRO%20Green%20Line&stop=Target%20Field%20Station%20Platform%202&direction=east`
- `/route/nextbus?route=METRO%20Green%20Line&stop=West%20Bank%20Station&direction=east`
- `/route/nextbus?route=METRO%20Green%20Line&stop=Union%20Depot%20Station&direction=east`

### Westbound
- `/route/nextbus?route=METRO%20Green%20Line&stop=Union%20Depot%20Station&direction=west`
- `/route/nextbus?route=METRO%20Green%20Line&stop=Snelling%20Ave%20Station&direction=west`
- `/route/nextbus?route=METRO%20Green%20Line&stop=Target%20Field%20Station%20Platform%201&direction=west`

---

## METRO Red Line

### Northbound
- `/route/nextbus?route=METRO%20Red%20Line&stop=Apple%20Valley%20Transit%20Station&direction=north`
- `/route/nextbus?route=METRO%20Red%20Line&stop=Cedar%20Grove%20Transit%20Station&direction=north`
- `/route/nextbus?route=METRO%20Red%20Line&stop=Mall%20of%20America%20Transit%20Station&direction=north`

### Southbound
- `/route/nextbus?route=METRO%20Red%20Line&stop=Mall%20of%20America%20Transit%20Station&direction=south`
- `/route/nextbus?route=METRO%20Red%20Line&stop=140th%20St%20Station&direction=south`

---

## METRO Orange Line

### Northbound
- `/route/nextbus?route=METRO%20Orange%20Line&stop=Burnsville%20Heart%20of%20the%20City%20Station&direction=north`
- `/route/nextbus?route=METRO%20Orange%20Line&stop=I-35W%20%26%2098th%20St%20Station&direction=north`
- `/route/nextbus?route=METRO%20Orange%20Line&stop=2nd%20Ave%20and%207th%20St&direction=north`

### Southbound
- `/route/nextbus?route=METRO%20Orange%20Line&stop=Marquette%20Ave%20and%203rd%20St&direction=south`
- `/route/nextbus?route=METRO%20Orange%20Line&stop=I-35W%20%26%2046th%20St%20Station&direction=south`

---

## METRO Gold Line

### Eastbound
- `/route/nextbus?route=METRO%20Gold%20Line&stop=Smith%20%26%205th%20St%20Station&direction=east`
- `/route/nextbus?route=METRO%20Gold%20Line&stop=Sun%20Ray%20Station&direction=east`

### Westbound
- `/route/nextbus?route=METRO%20Gold%20Line&stop=Woodlane%20Dr%20Station&direction=west`
- `/route/nextbus?route=METRO%20Gold%20Line&stop=6th%20St%20%26%20Minnesota%20Station&direction=west`

---

Be sure to replace values as needed. Only use route/stop names that are uniquely identifiable for accurate results.

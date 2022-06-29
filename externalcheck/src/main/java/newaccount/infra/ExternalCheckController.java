package newaccount.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import newaccount.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value = "/externalChecks")
@Transactional
public class ExternalCheckController {
    
    @Autowired
    ExternalCheckRepository externalCheckRepository;
    // keep
    @GetMapping("/externalChecks/checkincome/{regNo}")
    public ResponseEntity getByRegistNo(@PathVariable String regNo) {
        Optional accountData = externalCheckRepository.findByRegNo(regNo);
        
        if (accountData.isPresent()) {
            return new ResponseEntity<>(accountData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}

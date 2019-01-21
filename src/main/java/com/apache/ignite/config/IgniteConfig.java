package com.apache.ignite.config;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.apache.ignite.model.Contact;
import com.apache.ignite.model.Person;

@Configuration
public class IgniteConfig {

  @Bean
  public Ignite igniteInstance() {
    IgniteConfiguration cfg = new IgniteConfiguration();
    cfg.setIgniteInstanceName("ignite-cluster-node");
    cfg.setClientMode(true);
    CacheConfiguration ccfg1 = new CacheConfiguration("PersonCache");
    ccfg1.setIndexedTypes(Long.class, Person.class);
    CacheConfiguration ccfg2 = new CacheConfiguration("ContactCache");
    ccfg2.setIndexedTypes(Long.class, Contact.class);
    cfg.setCacheConfiguration(ccfg1, ccfg2);
    return Ignition.start(cfg);
  }

}
